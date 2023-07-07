package techproed.day23_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C01_Log4j {

    /*
    Log4j system.out.println gibi her test adiminda bilgilendirme yapmamiza yarayan bir api'dir.
    Log4j ile bu bilgilendirmeleri hem konsolda tarih olarak hem de src>main>resources icine koydugumuz log4j.xml file'da
    belirttigimiz .log uzantili dosyada yine tarih saat olarak kayit altina almis olacagiz
    Log4j kullanabilmek icn öncelikle log4j-api ve log4j-core depency'lerini mvnrepository.com adresinden  (ayni versiyon
    numaralarina sahip) alip pom.xml dosyamiza koymaliyiz
    src>main>resources icine koydugumuz log4j.xml dosyasindaki kodlara pdf'teki adresten ulasabilirsiniz
     */

    @Test
    public void log4j() {

        Logger logger = LogManager.getLogger(C01_Log4j.class);
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARNING");
    }
}
