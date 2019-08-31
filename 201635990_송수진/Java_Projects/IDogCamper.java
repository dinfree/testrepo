package dogcamper;

import java.io.IOException;

public interface IDogCamper {
	void genCamper();
	void genCampSite();
	void start() throws IOException;
	void book() throws IOException ;
}
