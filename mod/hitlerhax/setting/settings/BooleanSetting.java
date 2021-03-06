// 
// Decompiled by Procyon v0.5.36
// 

package mod.hitlerhax.setting.settings;

import mod.hitlerhax.event.events.HtlrEventSettings;
import mod.hitlerhax.event.HtlrEventBus;
import mod.hitlerhax.Main;
import mod.hitlerhax.module.Module;
import mod.hitlerhax.setting.Setting;

public class BooleanSetting extends Setting
{
    public boolean enabled;
    
    public BooleanSetting(final String name, final Module parent, final boolean enabled) {
        this.name = name;
        this.parent = parent;
        this.enabled = enabled;
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
        if (Main.config != null) {
            Main.config.Save();
        }
        HtlrEventBus.EVENT_BUS.post(new HtlrEventSettings(this, this.parent));
    }
    
    public void toggled() {
        this.enabled = !this.enabled;
        if (Main.config != null) {
            Main.config.Save();
        }
    }
}
