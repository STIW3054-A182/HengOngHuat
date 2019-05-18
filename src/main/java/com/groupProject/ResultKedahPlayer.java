package com.groupProject;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lim Xin Yi
 * @version 1.0
 * @since 2019-04-25
 * Create ResultKedahPlayer class from ValidTableLink and implements with Runnable
 * ResultKedahPlayer uses to get result of players from Kedah
 */

public class ResultKedahPlayer extends ValidTableLink implements Runnable {
    public  ResultKedahPlayer(){}

    /**
     * This constructs a result of kedah player with a specified existList,existLinkList,existTableList,existTableLinkList.
     * @param existList valid link
     * @param existLinkList valid link list
     * @param existTableList valid table link
     * @param existTableLinkList valid table link list
     */

