package rough;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import utility.CommonUtils;

public class Two_Test_getAndroidDriver {
@Test
public void getAndroidDriver() throws IOException
{
	CommonUtils objCommonUtils=new CommonUtils();
	objCommonUtils.loadAndroidBaswareConfProp("Android_basware.properties");
	objCommonUtils.print_properties();
	objCommonUtils.setAndroidCapabilites();
	objCommonUtils.getAndroidDriver();
	
}
}
