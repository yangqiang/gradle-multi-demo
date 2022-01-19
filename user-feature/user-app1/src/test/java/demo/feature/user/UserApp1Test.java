package demo.feature.user;


import org.junit.jupiter.api.Test;

class UserApp1Test {

    @Test
    void calculate() {
        UserApp1 app1 = new UserApp1();
        System.out.println(app1.calculate());
    }
}