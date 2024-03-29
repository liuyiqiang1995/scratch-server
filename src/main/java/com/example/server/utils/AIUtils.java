package com.example.server.utils;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
import com.baidu.aip.face.AipFace;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.imageprocess.AipImageProcess;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.speech.AipSpeech;

/**
 * <功能描述>
 *
 * @author
 * @date 2021/8/10 14:04
 */
public class AIUtils {

    public static AipImageClassify getImageClient() {
        AipImageClassify client = new AipImageClassify("24667544", "Ewv3X3GTIG3FMUAv8c0En1Za", "SMldQouVe1Z5iO03Ezo7TZPE9EdyvAS4");
        return client;
    }

    public static AipImageProcess getImageProcessClient() {
        AipImageProcess client = new AipImageProcess("24680995", "KbSfM3HcTAAVZDqWI2zBU7jh", "2GwSwIPfrcw3pRGReNVIr9UuvMGGl4UG");
        return client;
    }

    public static AipOcr getOcrClient() {
        AipOcr client = new AipOcr("24689350", "aAeFDFH8dkMYfGrHjdWVbxbE", "8tA3XoRA4DwUWzldEFHPsbwpSkNOZZWe");
        return client;
    }

    public static AipSpeech getVoiceClient() {
        AipSpeech client = new AipSpeech("24592949", "6k74vEiLkxwoMe1ADP3349LK", "k62Wogyca04KnE6oNagLHnUQcaRjjUNE");
        return client;
    }

    public static AipBodyAnalysis getBodyClient() {
        AipBodyAnalysis client = new AipBodyAnalysis("24733252", "q6kapec9QTelblQykYi0n4TF", "dKklLEudzcLIeIPkT8IQyy10S9FRfw0W");
        return client;
    }

    public static AipFace getFaceClient() {
        AipFace client = new AipFace("24733412", "bp5XQtzPwzGC7OmbLgqg0HZh", "lGD8SH8VZGx27yOLoeCTudZP04U0teMh");
        return client;
    }

    public static AipNlp getNlpClient() {
        AipNlp client = new AipNlp("24750253", "jaGV06yUkZbbA8ljMKNWb1HK", "wKDNVLihm0droA0MYf8UsOgwOzVBULv2");
        return client;
    }
}
