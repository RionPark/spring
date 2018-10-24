package com.spring.init.ws;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.init.vo.UserInfoVO;


@ServerEndpoint(value = "/alarm", 
        configurator = GetHttpSessionConfigurator.class)
public class WebSocketTest {	

	private static final Logger log = LoggerFactory.getLogger(WebSocketTest.class);
	private static Map<String,Session> sessionMap = Collections
			.synchronizedMap(new HashMap<String,Session>());
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@OnMessage
	public void onMessage(String text, Session session) throws IOException {

	    TypeReference<HashMap<String,Object>> typeRef 
	            = new TypeReference<HashMap<String,Object>>() {};
		Map<String,String> map = mapper.readValue(text, typeRef);
		log.info("text = >{}",map);
		String targetId = map.get("target");
		
		synchronized (sessionMap) {
			final Iterator<String> it = sessionMap.keySet().iterator();
			while(it.hasNext()) {
				final String key = it.next();
				if(key.equals(targetId)) {
					Session ss = sessionMap.get(key);
					ss.getBasicRemote().sendText(text);
				}
			}
		}
	}
	
	private String getSessionKey(Session session) {
		final Iterator<String> it = sessionMap.keySet().iterator();
		while(it.hasNext()) {
			final String key = it.next();
			if(session.equals(sessionMap.get(key))){
				return key;
			}
		}
		return null;
	}
	
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		final HttpSession hs = (HttpSession) config.getUserProperties()
                .get(HttpSession.class.getName());
		//로그인처리를 했다는 가정하에 로그인을 할경우
		//http세션에 UserInfoVO를 저장한 후 웹소케세션을 매핑시킴.
		final UserInfoVO uiv = (UserInfoVO)hs.getAttribute("userInfo");
		final String userId = uiv.getUiId();
		sessionMap.put(userId, session);
	}

	@OnClose
	public void onClose(Session session) {
		String key = getSessionKey(session);
		if(key!=null) {
			sessionMap.remove(key);
		}
	}
}
