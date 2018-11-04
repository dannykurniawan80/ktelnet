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
import com.khubla.telnet.nvt.NVT;

public class TermtypeIACCommandHandlerImpl implements IACCommandHandler {
   /**
    * logger
    */
   static final Logger logger = LoggerFactory.getLogger(TermtypeIACCommandHandlerImpl.class);

   @Override
   public void process(NVT nvt, int cmd) throws IOException {
      switch (cmd) {
         case NVT.IAC_COMMAND_DO:
            logger.info("Received IAC DO Termtype");
            break;
         case NVT.IAC_COMMAND_DONT:
            logger.info("Received IAC DONT Termtype");
            break;
         case NVT.IAC_COMMAND_WILL:
            logger.info("Received IAC WILL Termtype");
            // great, please do send it along
            nvt.sendIACCommand(NVT.IAC_COMMAND_DO, NVT.IAC_CODE_TERMTYPE);
            break;
         case NVT.IAC_COMMAND_WONT:
            logger.info("Received IAC WONT Termtype");
            break;
         default:
            logger.info("Received Unknown IAC Command:" + cmd);
      }
   }
}
