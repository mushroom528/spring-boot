/*
 * Copyright 2012-2023 the original author or authors.
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

package org.springframework.boot.testcontainers.service.connection.neo4j;

import org.junit.jupiter.api.Test;
import org.neo4j.driver.AuthToken;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.predicate.RuntimeHintsPredicates;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Neo4jContainerConnectionDetailsFactory}.
 *
 * @author Moritz Halbritter
 */
class Neo4jContainerConnectionDetailsFactoryTests {

	@Test
	void shouldRegisterHints() {
		RuntimeHints hints = new RuntimeHints();
		new Neo4jContainerConnectionDetailsFactory().registerHints(hints, getClass().getClassLoader());
		assertThat(RuntimeHintsPredicates.reflection().onType(AuthToken.class)).accepts(hints);
	}

}
