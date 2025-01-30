/*
 * Copyright (c) 2019 Armory, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.spinnaker.orca.clouddriver.pipeline.providers.aws;

import com.netflix.spinnaker.orca.api.pipeline.graph.StageDefinitionBuilder;
import com.netflix.spinnaker.orca.api.pipeline.graph.TaskNode;
import com.netflix.spinnaker.orca.api.pipeline.models.StageExecution;
import com.netflix.spinnaker.orca.clouddriver.tasks.MonitorKatoTask;
import com.netflix.spinnaker.orca.clouddriver.tasks.providers.aws.lambda.LambdaFunctionForceRefreshTask;
import com.netflix.spinnaker.orca.clouddriver.tasks.providers.aws.lambda.LambdaFunctionTask;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Component;

@Component
public class LambdaFunctionStage implements StageDefinitionBuilder {
  public static final String PIPELINE_CONFIG_TYPE = "lambdaFunction";

  @Override
  public void taskGraph(@Nonnull StageExecution stage, @Nonnull TaskNode.Builder builder) {
    builder
        .withTask(LambdaFunctionTask.TASK_NAME, LambdaFunctionTask.class)
        .withTask("monitorLambdaFunction", MonitorKatoTask.class)
        .withTask(LambdaFunctionForceRefreshTask.TASK_NAME, LambdaFunctionForceRefreshTask.class);
  }
}
