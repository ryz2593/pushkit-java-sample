/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.huawei.push.examples;

import com.huawei.push.exception.HuaweiMesssagingException;
import com.huawei.push.message.AndroidConfig;
import com.huawei.push.message.Message;
import com.huawei.push.messaging.HuaweiApp;
import com.huawei.push.messaging.HuaweiMessaging;
import com.huawei.push.model.Urgency;
import com.huawei.push.reponse.SendResponse;
import com.huawei.push.util.InitAppUtils;

public class SendDataMessage {

    public static void main(String[] args) throws HuaweiMesssagingException {
        sendTransparent();
    }


    /**
     * send data message
     *
     * @throws HuaweiMesssagingException
     */
    public static void sendTransparent() throws HuaweiMesssagingException {
        HuaweiApp app = InitAppUtils.initializeApp();
        HuaweiMessaging huaweiMessaging = HuaweiMessaging.getInstance(app);

        AndroidConfig androidConfig = AndroidConfig.builder().setCollapseKey(-1)
                .setUrgency(Urgency.HIGH.getValue())
                .setTtl("10000s")
                .setBiTag("the_sample_bi_tag_for_receipt_service")
                .build();

        String token = "ALL0u2XCIYnGkETGbMRKoAD_o6e1ZK58uVivgwR6vhZCM4V_DafkzzZ8UvLx8h_zW4eO6F9Ug5aMvDtyNvRgEwIoYYrS5WdodjpXkmwfCWltPVwr-AtAizlomlVxfB1h6Q";

        Message message = Message.builder()
                .setData("{\\\"badge\\\":1}")
                .setAndroidConfig(androidConfig)
                .addToken(token)
                .build();

        SendResponse response = huaweiMessaging.sendMessage(message);
    }
}
