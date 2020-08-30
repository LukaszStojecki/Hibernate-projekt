package hibernateTest;


import dao.MovieDao;
import entity.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
public class HibernateMovieTest {

    private static final String SOME_TITLE = "someTitle";
    @InjectMocks
    private MovieDao movieDao = new MovieDao();
    @Mock
    private SessionFactory sessionFactoryMock;
    @Mock
    private Session sessionMock;
    @Mock
    private Transaction transactionMock;
    @Captor
    ArgumentCaptor<Movie> movieCaptor;
    @Before
    public void setup() {
        when(sessionFactoryMock.openSession()).thenReturn(sessionMock);
    }
    @Test
    public void shouldSaveAmovie() {
       // when(sessionMock.beginTransaction()).thenReturn(transactionMock);
      //  when(sessionMock.beginTransaction()).thenThrow(new Exception("błąd"));
       // verify(transactionMock, times(1)).rollback();
        Movie movie = new Movie(SOME_TITLE);
        movieDao.save(movie);
        Mockito.verify(sessionMock).saveOrUpdate(movieCaptor.capture());
        Movie capturedMovie = movieCaptor.getValue();

        assert(capturedMovie.equals(movie));
    }

}

