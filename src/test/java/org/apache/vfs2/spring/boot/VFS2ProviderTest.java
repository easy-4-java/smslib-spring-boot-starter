package org.apache.vfs2.spring.boot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.vfs2.VFS;
import org.junit.Test;

import com.sshtools.vfs.nfs.NFSFileProvider;
import com.sshtools.vfs.nfs.NFSFileSystem;
import com.sshtools.vfs.nfs.NFSFileName;

public class VFS2ProviderTest {

    @Test
    public void nfsProviderLoadsWithoutServer() throws Exception {
        assertTrue(VFS.getManager().hasProvider("nfs"));
        assertFalse(new NFSFileProvider().getCapabilities().isEmpty());
        assertNotNull(NFSFileSystem.class.getDeclaredConstructor(
                NFSFileName.class,
                org.apache.commons.vfs2.FileSystemOptions.class,
                com.emc.ecs.nfsclient.nfs.nfs3.Nfs3.class));
    }
}
