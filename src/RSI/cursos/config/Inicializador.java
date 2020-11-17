package RSI.cursos.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Inicializador implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		//Crea el contexto raiz de la aplicacion web
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringConfig.class);
		
		// Gestiona el ciclo de vida del contextp de aplicación
		container.addListener(new ContextLoaderListener(rootContext));
		
		// crea el DispatcherServlet y lo asocia al contexto de
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(MvcConfig.class);
		
		// Registra el dispatcherServlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
