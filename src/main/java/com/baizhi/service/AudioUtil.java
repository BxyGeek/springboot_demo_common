package com.baizhi.service;

/**
 * @Author: buxy
 * @Date: 2019/3/21  11:50
 */
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

public class AudioUtil {

    /**
     * 获取音频文件时长
     *
     * @param wavFilePath wav文件路径，支持本地和网络HTTP路径
     * @return 时长/微秒，可 /1000000D 得到秒
     * @throws Exception
     */
    public static long getMicrosecondLengthForWav(String wavFilePath) throws Exception {


        if (wavFilePath == null || wavFilePath.length() == 0) {
            return 0;
        }
        String bath = wavFilePath.split(":")[0];
        Clip clip = AudioSystem.getClip();
        AudioInputStream ais;
        if ("http".equals(bath.toLowerCase())||"https".equals(bath.toLowerCase())) {
            ais = AudioSystem.getAudioInputStream(new URL(wavFilePath));
        } else {
            ais = AudioSystem.getAudioInputStream(new File(wavFilePath));
        }
        clip.open(ais);
        return clip.getMicrosecondLength();
    }

    public static void main(String[] args) throws Exception {
        String wavUrl = "http://data.huiyi8.com/2017/gha/08/19/1969.wav";
        long microsecondLengthForWav = getMicrosecondLengthForWav(wavUrl);
        System.out.println(microsecondLengthForWav/1000000+"秒");


    }
}
