/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.actuate.autoconfigure.endpoint;

import org.springframework.boot.actuate.endpoint.web.EndpointPathResolver;
import org.springframework.core.env.Environment;

/**
 * Default {@link EndpointPathResolver} implementation that use the
 * {@link Environment} to determine if an endpoint has a custom path.
 *
 * @author Stephane Nicoll
 */
class DefaultEndpointPathResolver implements EndpointPathResolver {

	private final Environment environment;

	DefaultEndpointPathResolver(Environment environment) {
		this.environment = environment;
	}

	@Override
	public String resolvePath(String endpointId) {
		String key = String.format("endpoints.%s.web.path", endpointId);
		return this.environment.getProperty(key, String.class, endpointId);
	}

}
