package me.stella.mhcparticleaddon.particle;

import com.mojang.serialization.Codec;
import me.stella.mhcparticleaddon.MhcParticleAddon;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final ParticleType<ColorableSonicBoomEffect> COLORABLE_SONIC_BOOM = FabricParticleTypes.complex(ColorableSonicBoomEffect.FACTORY);

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MhcParticleAddon.MOD_ID, "colorable_sonic_boom"),
                COLORABLE_SONIC_BOOM);
    }
}
