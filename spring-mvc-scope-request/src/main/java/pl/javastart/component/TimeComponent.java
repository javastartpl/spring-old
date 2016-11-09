package pl.javastart.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.TARGET_CLASS) 
public class TimeComponent {

    private long time;
    
    public TimeComponent() {
        time = System.currentTimeMillis();
    }
    
    public long getTime() {
        return time;
    }
    
    @PostConstruct
    public void afterCreated() {
        System.out.println(this + " created");
    }
    
    @PreDestroy
    public void beforDestroy() {
        System.out.println(this + " destroyed");
    }
}