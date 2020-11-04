#!/bin/bash

echo "Hi There , Running from resources..."
echo "BUILD NUMBER ${BUILD_NUMBER}"
echo "WORKSPACE ${WORKSPACE}"
echo "JOB_NAME ${JOB_NAME}"
echo "BRANCH_NAME ${BRANCH_NAME}"
echo "NEXUS_PASSWORD ${NEXUS_PASSWORD}"
echo "NEXUS_USERNAME ${USERNAME}"
ls -la ${WORKSPACE}