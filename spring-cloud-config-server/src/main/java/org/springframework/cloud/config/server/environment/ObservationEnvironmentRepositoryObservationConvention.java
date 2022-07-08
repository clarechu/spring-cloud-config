/*
 * Copyright 2013-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.config.server.environment;

import io.micrometer.common.KeyValues;
import io.micrometer.observation.Observation;

/**
 * Default provider of key values for {@link ObservationEnvironmentRepositoryContext}.
 *
 * @author Marcin Grzejszczak
 * @since 4.0.0
 */
class ObservationEnvironmentRepositoryObservationConvention
		implements Observation.ObservationConvention<ObservationEnvironmentRepositoryContext> {

	// TODO: Do we care about application, profile, label tags?
	@Override
	public KeyValues getLowCardinalityKeyValues(ObservationEnvironmentRepositoryContext context) {
		return KeyValues.of(DocumentedConfigObservation.Tags.ENVIRONMENT_CLASS
				.of(context.getEnvironmentRepositoryClass().getName()));
	}

	@Override
	public boolean supportsContext(Observation.Context context) {
		return context instanceof ObservationEnvironmentRepositoryContext;
	}

	@Override
	public String getName() {
		return "find";
	}

}
