package me.stella.mhcparticleaddon;

import me.stella.mhcparticleaddon.particle.ColorableSonicBoom;
import me.stella.mhcparticleaddon.particle.ColorableSonicBoomEffect;
import me.stella.mhcparticleaddon.particle.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.SonicBoomParticle;
import net.minecraft.particle.ParticleEffect;

public class MhcParticleAddonClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.COLORABLE_SONIC_BOOM, ColorableSonicBoom.Factory::new);
    }
}
