package io.github.supercube.config;

/**
 * Framework constants.
 */
public interface FrameworkConstants {

    /** Constant <code>SPRING_PROFILE_DEVELOPMENT="dev"</code> */
    String SPRING_PROFILE_DEVELOPMENT = "dev";
    /** Constant <code>SPRING_PROFILE_TEST="test"</code> */
    String SPRING_PROFILE_TEST = "test";
    /** Constant <code>SPRING_PROFILE_PRODUCTION="prod"</code> */
    String SPRING_PROFILE_PRODUCTION = "prod";
    /** Spring profile used when deploying with Spring Cloud (used when deploying to CloudFoundry)
        Constant <code>SPRING_PROFILE_CLOUD="cloud"</code> */
    String SPRING_PROFILE_CLOUD = "cloud";
    /** Spring profile used when deploying to Heroku
        Constant <code>SPRING_PROFILE_HEROKU="heroku"</code> */
    String SPRING_PROFILE_HEROKU = "heroku";
    /** Spring profile used when deploying to Amazon ECS
        Constant <code>SPRING_PROFILE_AWS_ECS="aws-ecs"</code> */
    String SPRING_PROFILE_AWS_ECS = "aws-ecs";
    /** Spring profile used to enable swagger
        Constant <code>SPRING_PROFILE_SWAGGER="swagger"</code> */
    String SPRING_PROFILE_SWAGGER = "swagger";
    /** Spring profile used to disable running liquibase
        Constant <code>SPRING_PROFILE_NO_LIQUIBASE="no-liquibase"</code> */
    String SPRING_PROFILE_NO_LIQUIBASE = "no-liquibase";
    /** Spring profile used when deploying to Kubernetes and OpenShift
        Constant <code>SPRING_PROFILE_K8S="k8s"</code> */
    String SPRING_PROFILE_K8S = "k8s";


    /**
     * 用户名规则
     */
    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";

    /**
     * 系统账号
     * */
    public static final String SYSTEM_ACCOUNT = "system";

    /**
     * 默认语言
     * */
    public static final String DEFAULT_LANGUAGE = "zh";

    /**
     * 匿名用户
     * */
    public static final String ANONYMOUS_USER = "anonymoususer";

    /**
     * 常用图片格式
     */
    String REG_IMG_FORMAT = "^.+(.JPEG|.jpeg|.JPG|.jpg|.PNG|.png|.GIF|.gif)$";

    /**
     * 邮箱格式
     */
    String REG_EMAIL_FORMAT = "^[a-z_0-9.-]{1,64}@([a-z0-9-]{1,200}.){1,5}[a-z]{1,6}$";

    /**
     * 密码格式
     */
    String REG_USER_PASSWORD = ".{6,20}";

    /**
     * 手机号码格式
     */
    String REG_USER_MOBILE = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\\\d{8}$";

    /**
     * 敏感sql操作
     */
    String REG_SENSITIVE_SQL = "drop\\s|alert\\s|grant\\s|delete\\s|update\\s|remove\\s";


    /**
     * 匹配多行sql注解正则
     */
    String REG_SQL_ANNOTATE = "(?ms)('(?:''|[^'])*')|--.*?$|/\\*.*?\\*/";
}
