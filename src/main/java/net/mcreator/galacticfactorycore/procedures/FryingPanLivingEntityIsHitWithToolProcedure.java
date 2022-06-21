package net.mcreator.galacticfactorycore.procedures;

import net.minecraftforge.eventbus.api.Event;

public class FryingPanLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GalacticfactorycoreMod.LOGGER.warn("Failed to load dependency world for procedure FryingPanLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GalacticfactorycoreMod.LOGGER.warn("Failed to load dependency entity for procedure FryingPanLivingEntityIsHitWithTool!");
			return;
		}

		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");

		if (EntityTypeTags.getCollection().getTagByID(new ResourceLocation("entityplayermp")).contains(entity.getType())) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("YOU'VE BEEN HIT BY"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			new Object() {

				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (!world.isRemote()) {
						MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
						if (mcserv != null)
							mcserv.getPlayerList().func_232641_a_(new StringTextComponent("YOU'VE BEEN STRUCK BY"), ChatType.SYSTEM, Util.DUMMY_UUID);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}

			}.start(world, (int) 10);
			new Object() {

				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (!world.isRemote()) {
						MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
						if (mcserv != null)
							mcserv.getPlayerList().func_232641_a_(new StringTextComponent("PAN"), ChatType.SYSTEM, Util.DUMMY_UUID);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}

			}.start(world, (int) 10);
		}
	}

}
