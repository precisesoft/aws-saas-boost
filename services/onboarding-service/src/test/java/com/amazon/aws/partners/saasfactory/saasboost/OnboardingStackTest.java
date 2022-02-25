/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
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

package com.amazon.aws.partners.saasfactory.saasboost;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OnboardingStackTest {

    private static final List<String> CLOUDFORMAION_STACK_STATUSES = Arrays.asList(
            "CREATE_COMPLETE",
            "CREATE_IN_PROGRESS",
            "CREATE_FAILED",
            "DELETE_COMPLETE",
            "DELETE_FAILED",
            "DELETE_IN_PROGRESS",
            "REVIEW_IN_PROGRESS",
            "ROLLBACK_COMPLETE",
            "ROLLBACK_FAILED",
            "ROLLBACK_IN_PROGRESS",
            "UPDATE_COMPLETE",
            "UPDATE_COMPLETE_CLEANUP_IN_PROGRESS",
            "UPDATE_IN_PROGRESS",
            "UPDATE_ROLLBACK_COMPLETE",
            "UPDATE_ROLLBACK_COMPLETE_CLEANUP_IN_PROGRESS",
            "UPDATE_ROLLBACK_FAILED",
            "UPDATE_ROLLBACK_IN_PROGRESS");

    @Test
    public void testIsComplete() {
        for (String status : CLOUDFORMAION_STACK_STATUSES) {
            OnboardingStack stack = new OnboardingStack();
            assertFalse(stack.isComplete());
            stack.setStatus(status);
            if ("CREATE_COMPLETE".equals(status)) {
                assertTrue(stack.isComplete());
            } else if ("UPDATE_COMPLETE".equals(status)) {
                assertTrue(stack.isComplete());
            } else {
                assertFalse(stack.isComplete());
            }
        }
    }
}
