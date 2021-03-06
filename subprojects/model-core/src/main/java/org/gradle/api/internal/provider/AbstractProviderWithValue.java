/*
 * Copyright 2019 the original author or authors.
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

package org.gradle.api.internal.provider;

import org.gradle.api.provider.Provider;

/**
 * A {@link org.gradle.api.provider.Provider} that always has a value defined. The value may not necessarily be final.
 */
public abstract class AbstractProviderWithValue<T> extends AbstractMinimalProvider<T> {
    @Override
    protected Value<? extends T> calculateOwnValue() {
        return Value.of(get());
    }

    @Override
    public abstract T get();

    @Override
    public T getOrNull() {
        return get();
    }

    @Override
    public T getOrElse(T defaultValue) {
        return get();
    }

    @Override
    public boolean isPresent() {
        return true;
    }

    @Override
    public Provider<T> orElse(T value) {
        return this;
    }

    @Override
    public Provider<T> orElse(Provider<? extends T> provider) {
        return this;
    }
}
