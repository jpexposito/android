package es.system.jpexposito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import es.system.jpexposito.model.User;
import es.system.jpexposito.model.helper.UsersDbHelper;

public class ModelUserUnitTest {
    static Context appContext = null;
    static User user = null;
    static UsersDbHelper usersDbHelper;

    @BeforeClass
    public static void beforeClass() {
        try {
            appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            usersDbHelper = new UsersDbHelper(appContext);
            user = new User("jjjj@gmail.com", "11223344");
            usersDbHelper.save(user);
        }catch (Exception ex) {
            fail("Se ha producido un error creando el elemento:"+ex.getMessage());
        }
    }

    @Test
    public void finfUserTest(){
        User userFind = usersDbHelper.getById(user.getEmail());
        assertNotNull("El usuario encontrado es null", userFind);
        assertEquals("El objeto almacenado y encontrado no son iguales",userFind, user);
    }

    @Test
    public void finfUsersTest(){
        List<User> users = usersDbHelper.getAll();
        assertNotNull("El numero de usuarios encontrado es menor de 1", users.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales",users.get(0), user);
    }
}
