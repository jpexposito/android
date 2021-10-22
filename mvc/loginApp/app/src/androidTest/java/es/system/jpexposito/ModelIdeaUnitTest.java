package es.system.jpexposito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.List;

import es.system.jpexposito.vo.User;

public class ModelIdeaUnitTest extends ComunUtilsTest{

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
