/**
 *
 *
 * main branch   - > prod env
 * hotfix branch
 *          |
 * release branch - > release env
 * dev branch   - > dev env
 * feature branch
 *
 *                  code coverage
 *                  code sanity check
 *                  ...
 *                  Sonarqube              ECS(task definition)
 *                     |                    |
 * build -> test -> report -> package -> deploy
 *           |                   |
 *         junit             docker image
 *         mockito -> mock
 *
 *
 */