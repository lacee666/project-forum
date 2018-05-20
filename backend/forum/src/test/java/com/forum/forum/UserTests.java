package tests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import project-forum.backend.forum.src.main.java.com.forum.forum.model.User;
import project-forum.backend.forum.src.main.java.com.forum.forum.service.UserService;
import project-forum.backend.forum.src.main.java.com.forum.forum.service.exception.UserNotValidException;
import project-forum.backend.forum.src.main.java.com.forum.forum.repository.UserRepository;
import java.util.Optional;


public class UserTests {

    private UserService us;
    private UserRepository ur;

    @Test
    public void registerUserTest(){

        us = new UserService();

        User[] badUsers = {
                new User("hosszabbTizenHatKarakternél", "vaskoota1", "vaskoota@projekt.hu"),
                new User("vaskoota", "hosszabbTizenHatKarakternél", "vaskoota@projekt.hu"),
                new User("hosszabbTizenHatKarakternél", "hosszabbTizenHatKarakternél", "vaskoota@projekt.hu"),
                new User("ezJóNévnek", "<6", "vaskoota@projekt.hu"),
                new User("<6", "ezJóJelszó", "vaskoota@projekt.hu"),
                new User("<6", "<6", "vaskoota@projekt.hu"),
                new User("<6", "hosszabbTizenHatKarakternél", "vaskoota@projekt.hu"),
                new User("hosszabbTizenHatKarakternél", "<6", "vaskoota@projekt.hu"),
        };

        boolean isEveryUserBad = true;

        for(User u : badUsers){
            try{
                us.register(u);
                isEveryUserBad = false;
            } catch(UserNotValidException e){}
        }
        assertTure(isEveryUserBad);


        User[] goodUsers = {
               new User("11111111vaskoota", "vaskoota1", "vaskoota@projekt.hu"),    //a felhasználónév a felső határon van
               new User("laceee666", "111111laceee6661", "laceee666@projekt.hu"),   //a jelszó a felső határon van
               new User("1111111morgromir", "111111morgromir1", "morgromir@projekt.hu"),    //a jelszó és a felhasználó is a felső határon van
               new user("velkei", "asdasdsa", "asdasdas@asdasd.hu"), //a felhasználó az alsó határon van
               new user("velkeib", "asdasd", "asdasdas@asdasd.hu"), //a jelszó az alsó határon van
               new User("velkei", "belkei", "velkeib@projekt.hu"),  //a felhasználó és a jelszó is az alsó határon van
               new User("velkei", "111111morgromir1", "velkeib@projekt.hu"),  //a felhasználó az alsó a jelszó pedig a felső határon van
               new User("velkei", "belkei", "velkeib@projekt.hu"),  //a felhasználó a felső a jelszó pedig az alsó határon van

        };

        boolean isEveryUserGood = true;

        for(User u : goodUsers){
            try{
                us.register(u);
            } catch(UserNotValidException e){isEveryUserGood = false;}
        }
        assertTure(isEveryUserGood);

        ur = new UserRepository();
        for(User u : goodUsers){
            ur.deleteByUsername(u.getUsername());
        }
    }

    @Test
    public void loginUserTest(){
        us = new UserService();

        User[] badUsers = {
                new User("hosszabbTizenHatKarakternél", "vaskoota1", "vaskoota@projekt.hu"),
                new User("vaskoota", "hosszabbTizenHatKarakternél", "vaskoota@projekt.hu"),
                new User("hosszabbTizenHatKarakternél", "hosszabbTizenHatKarakternél", "vaskoota@projekt.hu"),
                new User("ezJóNévnek", "<6", "vaskoota@projekt.hu"),
                new User("<6", "ezJóJelszó", "vaskoota@projekt.hu"),
                new User("<6", "<6", "vaskoota@projekt.hu"),
                new User("<6", "hosszabbTizenHatKarakternél", "vaskoota@projekt.hu"),
                new User("hosszabbTizenHatKarakternél", "<6", "vaskoota@projekt.hu"),
        };

        User[] goodUsers = {
                new User("11111111vaskoota", "vaskoota1", "vaskoota@projekt.hu"),    //a felhasználónév a felső határon van
                new User("laceee666", "111111laceee6661", "laceee666@projekt.hu"),   //a jelszó a felső határon van
                new User("1111111morgromir", "111111morgromir1", "morgromir@projekt.hu"),    //a jelszó és a felhasználó is a felső határon van
                new user("velkei", "asdasdsa", "asdasdas@asdasd.hu"), //a felhasználó az alsó határon van
                new user("velkeib", "asdasd", "asdasdas@asdasd.hu"), //a jelszó az alsó határon van
                new User("velkei", "belkei", "velkeib@projekt.hu"),  //a felhasználó és a jelszó is az alsó határon van
                new User("velkei", "111111morgromir1", "velkeib@projekt.hu"),  //a felhasználó az alsó a jelszó pedig a felső határon van
                new User("velkei", "belkei", "velkeib@projekt.hu"),  //a felhasználó a felső a jelszó pedig az alsó határon van

        };

        for(User u : goodUsers){
            try{
                us.register(u);
            } catch(UserNotValidException e){}
        }

        isEveryUserLoggedin = true;
        for(User u : goodUsers){
            try{
                us.login(u);
            } catch(UserNotValidException e){isEveryUserLoggedin = false;}
        }
        assertTrue(isEveryUserLoggedin);

        Optional<User> user;

        for(User u : badUsers){
            try{
                user = us.login(u);
                assertTrue(user == Optional.empty());
            } catch(UserNotValidException e){}
        }

        try{
            assertTrue(us.login(null) == null);
        } catch(UserNotValidException e){}

        ur = new UserRepository();
        for(User u : goodUsers){
            ur.deleteByUsername(u.getUsername());
        }
    }


}
