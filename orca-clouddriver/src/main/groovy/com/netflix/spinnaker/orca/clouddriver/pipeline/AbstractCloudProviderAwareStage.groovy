/*
 * Copyright 2015 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.orca.clouddriver.pipeline

import com.netflix.spinnaker.orca.clouddriver.utils.CloudProviderAware
import com.netflix.spinnaker.orca.api.pipeline.graph.StageDefinitionBuilder
import groovy.util.logging.Slf4j

import jakarta.annotation.Nonnull

@Slf4j
abstract class AbstractCloudProviderAwareStage implements StageDefinitionBuilder, CloudProviderAware {
  private final String type

  AbstractCloudProviderAwareStage(String type) {
    this.type = type
  }

  @Nonnull
  @Override
  String getType() {
    return type
  }
}
