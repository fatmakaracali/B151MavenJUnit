package techproed.day08_Junit;

import org.junit.*;

public class C02_BeforeClassAfterClass {
    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan once calisir");
    }

    /*
    *BeforeClass, class'ta  en önce calisan methoddur
    * AfterClass, class'ta en son calisan methoddur.
    *
    * @BeforeClass ve @AfterClass methodlari sadece static methodlar ile calisir
    *
    *  /*
        Before class ve After class test methodlarimizdan once bir sefer calismasini istedigimiz kodlari bu methodlara
    koyariz. Mesela testlerimiz baslamadan once database baglantisi yapmak icin kullanilabilir yada hangi driver'i
    kullancaksak yine bunu BeforeClass'a koyabiliriz. Ayni sekilde testlerimizden sonra database'i sonlandirmak icin
    yada raporlarimizi sonlandirmak icin de kullanabiliriz. Ama kullanmak zorunda degiliz
     */


    @BeforeClass
    public static void beforeClass() throws Exception {

        System.out.println("Class'ta en once calisan methodtur, bir kez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Class'ta en son calisan methoddur, bir kez calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test method'undan sonra calisir");
    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");
    }
}
