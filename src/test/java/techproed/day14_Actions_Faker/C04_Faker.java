package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C04_Faker {

    @Test
    public void faker() {

        /*

         Faker class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir
         */

        Faker faker =new Faker();

        //faker objesini kullanarak bir lastName yazdıralım
        System.out.println("Soyİsim : "+faker.name().lastName());

        //faker objesini kullanarak bir fullName yazdıralım

        System.out.println("Isim : "+faker.name().firstName());

        System.out.println(faker.name().fullName());

        //faker objesini kullanarak bir adress yazdıralım

        System.out.println(faker.address().fullAddress());

        //faker objesini kullanarak bir tel_no yazdıralım

        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.phoneNumber().phoneNumber());

        //Rastgele 15 haneli bir numara yazdiralim

        System.out.println(faker.number().digits(15));

        //meslek

        System.out.println(faker.job().position());


    }

}
