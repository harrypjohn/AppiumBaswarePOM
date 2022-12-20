package rough;

import java.io.IOException;

import org.testng.annotations.Test;

import utility.CommonUtils;

public class One_Test_Android_basware_properties {
@Test
public void testAndroidbaswareproperties() throws IOException
{
	CommonUtils objCommonUtils=new CommonUtils();
	objCommonUtils.loadAndroidBaswareConfProp("Android_basware.properties");
	objCommonUtils.print_properties();
}
}
