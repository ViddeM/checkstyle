package com.puppycrawl.tools.checkstyle.checks.j2ee;

import com.puppycrawl.tools.checkstyle.BaseCheckTestCase;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;

public class HomeInterfaceCheckTest extends BaseCheckTestCase
{
    public void testDefault()
            throws Exception
    {
        final DefaultConfiguration checkConfig =
            createCheckConfig(RemoteHomeInterfaceCheck.class);
        final String[] expected = {
            "20:19: Method 'createSomething' must be non-void.",
            "20:19: Method 'createSomething' must throw 'java.rmi.RemoteException'.",
            "20:19: Method 'createSomething' must throw 'javax.ejb.CreateException'.",
            "22:19: Method 'findSomething' must throw 'java.rmi.RemoteException'.",
        };
        verify(checkConfig, getPath("j2ee/InputHomeInterface.java"), expected);
    }
}
