package vijumi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
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
import com.oesia.formacion.practica.remote.RemoteSender;

public class PutProcessTest {

	private MessageManager messageManager;

	private ArticleDao articleDao;
	
	private static final Logger LOGGER = Logger.getLogger(RemoteSender.class);


	@Before
	public void init() {

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
		LOGGER.debug(String.format("Test putProcessWithNewArticle()"));
		String message = "PUT|2|3|100|Pantalones|2|1|500";
		messageManager.recive(message);
		List<Article> articles = articleDao.findAll();
		assertEquals(message, 1, articles.size());
	}

	@Test
	public void putProcessWithArticleSizeNotExist() {
		LOGGER.debug(String.format("Test putProcessWithArticleSizeNotExist()"));
		String message = "PUT|3|3|200|Camiseta|2|6|500";
		messageManager.recive(message);
		List<Article> articles = articleDao.findAll();
		assertEquals(message, 0, articles.size());
	}

	@Test
	public void putProcessWithNewArticles() {
		LOGGER.debug(String.format("Test putProcessWithNewArticles()"));
		String message = "PUT|2|3|300|Pantalones|2|1|200*3|1|301|Pantalones|3|3|200*4|2|302| |1|4|200";
		messageManager.recive(message);
		List<Article> articles = articleDao.findAll();
		assertEquals(message, 3, articles.size());
	}

	@Test
	public void putProcessWithOldArticles() {
		LOGGER.debug(String.format("Test putProcessWithOldArticles()"));
		String message = "PUT|2|3|300|Pantalones|2|1|200*3|1|301|Pantalones|3|3|200*4|2|301||1|4|200";
		messageManager.recive(message);
		Article article = articleDao.findById(301);
		assertEquals(message, 400, article.getNumUnit());		
	}
	
	@Test
	public void putProcessWithOldArticlesEmptyDescription() {
		LOGGER.debug(String.format("Test putProcessWithOldArticlesEmptyDescription()"));
		String message = "PUT|3|1|301|Pantalones|3|3|200*4|2|301||1|4|200";
		messageManager.recive(message);
		Article article = articleDao.findById(301);
		assertEquals(message, "", article.getDescription());		
	}
}
