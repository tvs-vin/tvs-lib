package tvs.lib;

import net.fabricmc.loader.api.FabricLoader;

public class Resources {
    public static void LoadTest(boolean fullTest) {
        if (fullTest) /* Runs every commmand and voids the output after logging to terminal. */ {
            Tvslib.LOGGER.info("Testing TVS-lib access");
            final String logMessage = "EnvType returned " + EnvType(0);
            Tvslib.LOGGER.info(logMessage);


        }
    }

    public static int EnvType(int expectedType) {
        // Gets client type and returns a boolean value. Checks multiple times to ensure accuracy.
        // Returns 0 for Det Server, 1 for Client, and -1 for unknown.

        final String GameEnv = FabricLoader.getInstance().getEnvironmentType().toString();

        tvs.lib.Tvslib.LOGGER.info("Running enviroment type " + GameEnv);

        if (GameEnv.equals("CLIENT")) {
            tvs.lib.Tvslib.LOGGER.debug("Running in client environment");
            if (expectedType != 1) {
                tvs.lib.Tvslib.LOGGER.warn("Expected client environment, but got " + GameEnv);}
            return 1;
        } else if (GameEnv.equals("SERVER")) {
            if (expectedType != 0) {
                tvs.lib.Tvslib.LOGGER.warn("Expected server environment, but got " + GameEnv);}
            tvs.lib.Tvslib.LOGGER.debug("Running in server environment");
            return 0;
        } else {
            tvs.lib.Tvslib.LOGGER.warn("Unknown environment type - " + GameEnv);
            return -1;
        }

    }


}
