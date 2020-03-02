package vijumi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.oesia.formacion.practica.architecture.communications.MessageManager;
import com.oesia.formacion.practica.architecture.domain.model.Article;
import com.oesia.formacion.practica.architecture.persistence.daos.article.ArticleDao;
import com.oesia.formacion.practica.context.Context;
import com.oesia.formacion.practica.context.ContextFactory;
import com.oesia.formacion.practica.remote.RemoteManager;
import com.oesia.formacion.practica.remote.RemoteManagerImpl;


public class PutProcessTest {

	
	private MessageManager messageManager;
	
	private ArticleDao articleDao;
	
	@Before
	public void init(){
		
		MockitoAnnotations.initMocks(this);
		final Context context = ContextFactory.getContext();
		context.set(RemoteManager.class, new RemoteManagerImpl());
		context.start();
		articleDao = ContextFactory.getContext().get(ArticleDao.class);
		messageManager = ContextFactory.getContext().get(MessageManager.class);
//		operacionBancaria = new OperacionBancariaImpl();
//		Mockito.when(facadeClienteBanco.findClienteBancoByDni("48914707D")).thenReturn(new ClienteBanco("48914707D", 1500));
//		Mockito.when(facadeClienteBanco.findClienteBancoByDni("12345678D")).thenReturn(new ClienteBanco("12345678D", 5000));

	}
	
	@Test
	public void putProcessWithNewArticle() {
		String message = "PUT|2|3|85|Pantalones|2|1|500";
		messageManager.recive(message);
		List<Article> articles = articleDao.findAll();
		assertEquals(message, 1, articles.size()); 
	}
	
	@Test
	public void putProcessWithArticleSizeNotExist() {
	
	}
	
	@Test
	public void putProcessWithNewArticles() {
		
	}
	
	@Test
	public void putProcessWithOldArticles() {
		
	}
}
