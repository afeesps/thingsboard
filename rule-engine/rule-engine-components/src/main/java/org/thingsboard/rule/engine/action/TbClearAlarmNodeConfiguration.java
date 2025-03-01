/**
 * Copyright © 2016-2021 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.rule.engine.action;

import lombok.Data;
import org.thingsboard.rule.engine.api.NodeConfiguration;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;

@Data
public class TbClearAlarmNodeConfiguration extends TbAbstractAlarmNodeConfiguration implements NodeConfiguration<TbClearAlarmNodeConfiguration> {

    @Override
    public TbClearAlarmNodeConfiguration defaultConfiguration() {
        TbClearAlarmNodeConfiguration configuration = new TbClearAlarmNodeConfiguration();
        configuration.setAlarmDetailsBuildJs("" +
                "//***DO NOT CHANGE THIS LINES***\n" +
                "var details = {};\n" +
                "if (metadata.prevAlarmDetails) {\n" +
                "    details = JSON.parse(metadata.prevAlarmDetails);\n" +
                "    //remove prevAlarmDetails from metadata\n" +
                "    delete metadata.prevAlarmDetails;\n" +
                "    //now metadata is the same as it comes IN this rule node" +
                "}\n" +
                "//***PLACE YOUR CODE BELOW***\n" +
                "\n" +
                "\n" +
                "return details;");
        configuration.setAlarmType("General Alarm");
        return configuration;
    }
}
