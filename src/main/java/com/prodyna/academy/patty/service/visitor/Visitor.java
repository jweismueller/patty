package com.prodyna.academy.patty.service.visitor;

import com.prodyna.academy.patty.domain.Folder;
import com.prodyna.academy.patty.domain.ImageFile;
import com.prodyna.academy.patty.domain.TextFile;
import com.prodyna.academy.patty.domain.VideoFile;

public interface Visitor {

	public abstract void visit(ImageFile file);

	public abstract void visit(TextFile file);

	public abstract void visit(VideoFile file);

	public abstract void visit(Folder folder);

}