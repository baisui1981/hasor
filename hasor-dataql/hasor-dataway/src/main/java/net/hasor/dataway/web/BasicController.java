/*
 * Copyright 2008-2009 the original author or authors.
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
package net.hasor.dataway.web;
import net.hasor.core.Inject;
import net.hasor.core.spi.SpiTrigger;
import net.hasor.dataway.dal.ApiDataAccessLayer;
import net.hasor.dataway.dal.ApiStatusEnum;
import net.hasor.dataway.dal.FieldDef;
import net.hasor.dataway.dal.QueryCondition;
import net.hasor.web.WebController;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 基础
 * @author 赵永春 (zyc@hasor.net)
 * @version : 2020-03-24
 */
public abstract class BasicController extends WebController {
    public static final Supplier<Map<FieldDef, String>> STATUS_UPDATE_TO_EDITOR    = () -> {
        return new HashMap<FieldDef, String>() {{
            put(FieldDef.STATUS, String.valueOf(ApiStatusEnum.Editor.typeNum()));
            put(FieldDef.GMT_TIME, String.valueOf(System.currentTimeMillis()));
        }};
    };
    public static final Supplier<Map<FieldDef, String>> STATUS_UPDATE_TO_PUBLISHED = () -> {
        return new HashMap<FieldDef, String>() {{
            put(FieldDef.STATUS, String.valueOf(ApiStatusEnum.Published.typeNum()));
            put(FieldDef.GMT_TIME, String.valueOf(System.currentTimeMillis()));
        }};
    };
    public static final Supplier<Map<FieldDef, String>> STATUS_UPDATE_TO_CHANGES   = () -> {
        return new HashMap<FieldDef, String>() {{
            put(FieldDef.STATUS, String.valueOf(ApiStatusEnum.Changes.typeNum()));
            put(FieldDef.GMT_TIME, String.valueOf(System.currentTimeMillis()));
        }};
    };
    public static final Supplier<Map<FieldDef, String>> STATUS_UPDATE_TO_DISABLE   = () -> {
        return new HashMap<FieldDef, String>() {{
            put(FieldDef.STATUS, String.valueOf(ApiStatusEnum.Disable.typeNum()));
            put(FieldDef.GMT_TIME, String.valueOf(System.currentTimeMillis()));
        }};
    };
    public static final Supplier<Map<FieldDef, String>> STATUS_UPDATE_TO_DELETE    = () -> {
        return new HashMap<FieldDef, String>() {{
            put(FieldDef.STATUS, String.valueOf(ApiStatusEnum.Delete.typeNum()));
            put(FieldDef.GMT_TIME, String.valueOf(System.currentTimeMillis()));
        }};
    };

    public static Map<QueryCondition, Object> conditionByApiId(String apiId) {
        return new HashMap<QueryCondition, Object>() {{
            put(QueryCondition.ApiId, apiId);
        }};
    }

    public static Map<QueryCondition, Object> emptyCondition() {
        return new HashMap<>();
    }

    @Inject
    protected SpiTrigger         spiTrigger;
    @Inject
    protected ApiDataAccessLayer dataAccessLayer;
}