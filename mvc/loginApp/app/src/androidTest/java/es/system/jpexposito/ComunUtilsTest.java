package es.system.jpexposito;

import static org.junit.Assert.fail;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.BeforeClass;

import es.system.jpexposito.model.helper.IdeaDbHelper;
import es.system.jpexposito.model.helper.UserDbHelper;
import es.system.jpexposito.vo.Idea;
import es.system.jpexposito.vo.User;

public class ComunUtilsTest {

    static Context appContext = null;
    static User user = null;
    static Idea idea;
    static UserDbHelper usersDbHelper;
    static IdeaDbHelper ideaDbHelper;

    @BeforeClass
    public static void beforeClass() {
        try {
            appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            usersDbHelper = new UserDbHelper(appContext);
            ideaDbHelper = new IdeaDbHelper(appContext);
            user = new User("jjjj@gmail.com", "11223344");
            usersDbHelper.save(user);
            idea = new Idea(user.getEmail(), "Descripcion de la idea");
            ideaDbHelper.save(idea);
        }catch (Exception ex) {
            fail("Se ha producido un error creando el elemento:"+ex.getMessage());
        }
    }

}
