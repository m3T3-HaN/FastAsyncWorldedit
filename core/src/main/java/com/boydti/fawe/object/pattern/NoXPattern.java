package com.boydti.fawe.object.pattern;

import com.sk89q.worldedit.MutableBlockVector;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.function.pattern.AbstractPattern;
import com.sk89q.worldedit.function.pattern.Pattern;

public class NoXPattern extends AbstractPattern {

    private final Pattern pattern;

    public NoXPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    private MutableBlockVector mutable = new MutableBlockVector();

    @Override
    public BaseBlock apply(Vector pos) {
        mutable.mutY((pos.getY()));
        mutable.mutZ((pos.getZ()));
        return pattern.apply(mutable);
    }

    @Override
    public boolean apply(Extent extent, Vector set, Vector get) throws WorldEditException {
        mutable.mutY((get.getY()));
        mutable.mutZ((get.getZ()));
        return pattern.apply(extent, set, mutable);
    }
}
