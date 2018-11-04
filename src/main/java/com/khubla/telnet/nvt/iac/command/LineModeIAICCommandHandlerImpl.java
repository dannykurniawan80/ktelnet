/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.telnet.nvt.iac.command;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.khubla.telnet.nvt.IACCommandHandler;
import com.khubla.telnet.nvt.IACHandler;
import com.khubla.telnet.nvt.NVT;

public class LineModeIAICCommandHandlerImpl extends AbstractIACCommandHandler {
   /**
    * logger
    */
   static final Logger logger = LoggerFactory.getLogger(LineModeIAICCommandHandlerImpl.class);
   /**
    * mode
    */
   public static final int MODE_MODE = 1;
   public static final int MODE_EDIT = 1;
   public static final int MODE_TRAPSIG = 2;
   public static final int MODE_MODE_ACK = 4;
   public static final int MODE_SOFT_TAB = 8;
   public static final int MODE_LIT_ECHO = 16;
   /**
    * forward mask
    */
   public static final int FORWARDMASK = 2;
   /**
    * SLC
    */
   public static final int SLC = 3;
   public static final int SLC_SYNCH = 1;
   public static final int SLC_BRK = 2;
   public static final int SLC_IP = 3;
   public static final int SLC_AO = 4;
   public static final int SLC_AYT = 5;
   public static final int SLC_EOR = 6;
   public static final int SLC_ABORT = 7;
   public static final int SLC_EOF = 8;
   public static final int SLC_SUSP = 9;
   public static final int SLC_EC = 10;
   public static final int SLC_EL = 11;
   public static final int SLC_EW = 12;
   public static final int SLC_RP = 13;
   public static final int SLC_LNEXT = 14;
   public static final int SLC_XON = 15;;
   public static final int SLC_XOFF = 16;
   public static final int SLC_FORW1 = 17;
   public static final int SLC_FORW2 = 18;
   public static final int SLC_MCL = 19;
   public static final int SLC_MCR = 20;
   public static final int SLC_MCWL = 21;
   public static final int SLC_MCWR = 22;
   public static final int SLC_MCBOL = 23;
   public static final int SLC_MCEOL = 24;
   public static final int SLC_INSRT = 25;
   public static final int SLC_OVER = 26;
   public static final int SLC_ECR = 27;
   public static final int SLC_EWR = 28;
   public static final int SLC_EBOL = 29;
   public static final int SLC_EEOL = 30;
   public static final int SLC_DEFAULT = 3;
   public static final int SLC_VALUE = 2;
   public static final int SLC_CANTCHANGE = 1;
   public static final int SLC_NOSUPPORT = 0;
   public static final int SLC_LEVELBITS = 3;
   public static final int SLC_ACK = 128;
   public static final int SLC_FLUSHIN = 64;
   public static final int SLC_FLUSHOUT = 32;
   /**
    * EOF
    */
   public static final int EOF = 236;
   /**
    * SUSP
    */
   public static final int SUSP = 237;
   /**
    * ABORT
    */
   public static final int ABORT = 238;

   @Override
   public void process(NVT nvt, int cmd) throws IOException {
      switch (cmd) {
         case IACCommandHandler.IAC_COMMAND_DO:
            logger.info("Received IAC DO linemode");
            break;
         case IACCommandHandler.IAC_COMMAND_DONT:
            logger.info("Received IAC DONT linemode");
            break;
         case IACCommandHandler.IAC_COMMAND_WILL:
            logger.info("Received IAC WILL linemode");
            // we dont do linemode
            nvt.sendIACCommand(IACCommandHandler.IAC_COMMAND_DONT, IACHandler.IAC_CODE_LINEMODE);
            break;
         case IACCommandHandler.IAC_COMMAND_WONT:
            logger.info("Received IAC WONT linemode");
            break;
         case IACCommandHandler.IAC_COMMAND_SB:
            logger.info("Received IAC SB linemode");
            break;
         default:
            logger.info("Received Unknown IAC Command:" + cmd);
      }
   }
}
