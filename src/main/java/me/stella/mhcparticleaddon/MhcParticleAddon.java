package me.stella.mhcparticleaddon;

import com.mojang.serialization.Codec;
import me.stella.mhcparticleaddon.particle.ColorableSonicBoom;
import me.stella.mhcparticleaddon.particle.ModParticles;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MhcParticleAddon implements ModInitializer {
	public static final String MOD_ID = "mhcparticleaddon";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final DefaultParticleType TEST = FabricParticleTypes.simple();



	@Override
	public void onInitialize() {

		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MOD_ID, "test"), TEST);

		LOGGER.info(MhcParticleAddon.MOD_ID + "has loaded");

		ModParticles.registerParticles();
	}
}