package es.system.jpexposito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.List;

import es.system.jpexposito.vo.Idea;

public class ModelIdeaUnitTest extends ComunUtilsTest{

    @Test
    public void findIdeadFromUserTest(){
        List<Idea> userIdeas = ideaDbHelper.getAll(user.getEmail());
        assertNotNull("El usuario encontrado es null", userIdeas);
        assertEquals("El usuario debe tener almacenadas al menos una idea",userIdeas.size(), 1);
    }
}
