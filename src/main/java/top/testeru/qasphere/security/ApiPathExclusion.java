package top.testeru.qasphere.security;



//不进行security校验的API
public class ApiPathExclusion {

    public ApiPathExclusion() {

    }

    public enum GetApiPathExclusion {

		HEALTH_CHECK("/ping"),
		SWAGGER_API_V2_DOCS("/v2/api-docs"),
		SWAGGER_RESOURCE_CONFIGURATION("/swagger-resources/configuration/ui"),
		SWAGGER_RESOURCES("/swagger-resources"),
		SWAGGER_RESOURCES_SECURITY_CONFIGURATION("/swagger-resources/configuration/security"),
		SWAGGER_UI_HTML("swagger-ui.html"),
		WEBJARS("/webjars/**"),
		SWAGGER_UI("/swagger-ui/**"),
		SWAGGER_API_V3_DOCS("/v3/api-docs/**"),
		SWAGGER_CONFIGURATION("/configuration/**"),
		SWAGGER("/swagger*/**");

		private final String path;

        public String getPath() {
            return path;
        }

        GetApiPathExclusion(String path) {
            this.path = path;
        }
    }


	public enum PostApiPathExclusion {

		SIGN_UP("/user/all"),
		LOGIN("/auth/login"),
        REGISTER("/auth/register");


		private final String path;

        PostApiPathExclusion(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }


	public enum PutApiPathExclusion {

		REFRESH_TOKEN("/refresh");

		private final String path;

        public String getPath() {
            return path;
        }

        PutApiPathExclusion(String path) {
            this.path = path;
        }
    }

}
