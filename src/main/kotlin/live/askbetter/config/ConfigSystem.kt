/*
 * Copyright © 2024 Integr
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package live.askbetter.config

import com.charleskorn.kaml.Yaml
import live.askbetter.config.parts.ConfigTree
import kotlin.io.path.Path
import kotlin.io.path.readText

class ConfigSystem {
    companion object {
        private var config: ConfigTree? = null

        fun load() {
            config = Yaml.default.decodeFromString(ConfigTree.serializer(), Path("./application.yaml").readText())
        }

        fun get(): ConfigTree {
            return config!!
        }
    }
}