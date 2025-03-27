package me.stella.mhcparticleaddon.particle;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Locale;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.dynamic.Codecs;
import org.joml.Vector3f;

public class ColorableSonicBoomEffect extends AbstractDustParticleEffect {

    /*public static final Vector3f SCULK_BLUE = Vec3d.unpackRgb(3790560).toVector3f();
    public static final ColorableSonicBoomEffect DEFAULT = new ColorableSonicBoomEffect(SCULK_BLUE, DustParticleEffect.RED, 1.0F);
   */
    public static final Codec<ColorableSonicBoomEffect> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            Codecs.VECTOR_3F.fieldOf("fromColor").forGetter(effect -> effect.color),
                            Codecs.VECTOR_3F.fieldOf("toColor").forGetter(effect -> effect.toColor),
                            Codec.FLOAT.fieldOf("scale").forGetter(effect -> effect.scale)
                    )
                    .apply(instance, ColorableSonicBoomEffect::new)
    );


    public static final ParticleEffect.Factory<ColorableSonicBoomEffect> FACTORY = new ParticleEffect.Factory<ColorableSonicBoomEffect>() {
        public ColorableSonicBoomEffect read(ParticleType<ColorableSonicBoomEffect> particleType, StringReader stringReader) throws CommandSyntaxException {
            Vector3f vector3f = AbstractDustParticleEffect.readColor(stringReader);
            stringReader.expect(' ');
            float f = stringReader.readFloat();
            Vector3f vector3f2 = AbstractDustParticleEffect.readColor(stringReader);
            return new ColorableSonicBoomEffect(vector3f, vector3f2, f);
        }

        public ColorableSonicBoomEffect read(ParticleType<ColorableSonicBoomEffect> particleType, PacketByteBuf packetByteBuf) {
            Vector3f vector3f = AbstractDustParticleEffect.readColor(packetByteBuf);
            float f = packetByteBuf.readFloat();
            Vector3f vector3f2 = AbstractDustParticleEffect.readColor(packetByteBuf);
            return new ColorableSonicBoomEffect(vector3f, vector3f2, f);
        }
    };

    private final Vector3f toColor;

    public ColorableSonicBoomEffect(Vector3f fromColor, Vector3f toColor, float scale) {
        super(fromColor, scale);
        this.toColor = toColor;
    }

    public Vector3f getFromColor() {
        return this.color;
    }

    public Vector3f getToColor() {
        return this.toColor;
    }

    @Override
    public void write(PacketByteBuf buf) {
        super.write(buf);
        buf.writeFloat(this.toColor.x());
        buf.writeFloat(this.toColor.y());
        buf.writeFloat(this.toColor.z());
    }

    @Override
    public String asString() {
        return String.format(
                Locale.ROOT,
                "%s %.2f %.2f %.2f %.2f %.2f %.2f %.2f",
                Registries.PARTICLE_TYPE.getId(this.getType()),
                this.color.x(),
                this.color.y(),
                this.color.z(),
                this.scale,
                this.toColor.x(),
                this.toColor.y(),
                this.toColor.z()
        );
    }

    @Override
    public ParticleType<ColorableSonicBoomEffect> getType() {
        return ModParticles.COLORABLE_SONIC_BOOM;
    }
}