package io.digdag.authenticator.plain;

import java.util.List;
import java.util.Arrays;
import com.google.inject.Module;
import com.google.inject.Binder;
import com.google.inject.Scopes;
import com.google.inject.multibindings.Multibinder;
import io.digdag.spi.StorageFactory;
import io.digdag.spi.Extension;

public class PlainAuthenticatorExtension
        implements Extension
{
    @Override
    public List<Module> getModules()
    {
        return Arrays.asList(new  PlainAuthenticatorModule());
    }

    public static class PlainAuthenticatorExtension
        implements Module
    {
        @Override
        public void configure(Binder binder)
        {
            Multibinder.newSetBinder(binder,  PlainAuthenticatorFactory.class)
                .addBinding().to(PlainAuthenticatorFactory.class).in(Scopes.SINGLETON);
        }
    }
}
