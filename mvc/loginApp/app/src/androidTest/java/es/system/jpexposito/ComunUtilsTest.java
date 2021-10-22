package es.system.jpexposito;

import static org.junit.Assert.fail;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.BeforeClass;

import es.system.jpexposito.vo.User;
import es.system.jpexposito.model.helper.UserDbHelper;

public class ComunUtilsTest {

    static Context appContext = null;
    static User user = null;
    static UserDbHelper usersDbHelper;

    @BeforeClass
    public static void beforeClass() {
        try {
            appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            usersDbHelper = new UserDbHelper(appContext);
            user = new User("jjjj@gmail.com", "11223344");
            usersDbHelper.save(user);
        }catch (Exception ex) {
            fail("Se ha producido un error creando el elemento:"+ex.getMessage());
        }
    }

}
