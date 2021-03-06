/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.axis2.jaxws.module;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisDescription;
import org.apache.axis2.description.AxisModule;
import org.apache.axis2.engine.AxisConfiguration;
import org.apache.axis2.modules.Module;
import org.apache.neethi.Assertion;
import org.apache.neethi.Policy;

public class JAXWSModule implements Module {

    public void engageNotify(AxisDescription axisDescription) throws AxisFault {
    }

    public void init(ConfigurationContext configurationContext, AxisModule module) throws AxisFault {
        AxisConfiguration axisConfiguration = configurationContext.getAxisConfiguration();
        registerGlobalModule(axisConfiguration, "jaxws");
    }

    public void shutdown(ConfigurationContext configurationContext) throws AxisFault {
    }

    public void applyPolicy(Policy policy, AxisDescription axisDescription)  throws AxisFault {
    }

    public boolean canSupportAssertion(Assertion assertion) {
        return false;
    }

    private void registerGlobalModule(AxisConfiguration axisConfiguration, String moduleName) {
        if (!axisConfiguration.getGlobalModules().contains(moduleName)) {
            axisConfiguration.addGlobalModuleRef(moduleName);
        }
    }
    
}
