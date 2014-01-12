//
//  SBHead.m
//  Follow the Finger
//
//  Created by Seth Battis on 3/30/11.
//  Copyright 2011 Milken Community High School. All rights reserved.
//

#import "SBHead.h"
#import "Head.h";

#define SMOOTH_MOVE 1

@implementation SBHead

-(void)draw
{
	if (abs(spin-target) < SMOOTH_MOVE)
	{
		spin = target;
	}
	if (spin < target)
	{
		spin += SMOOTH_MOVE;
	}
	else if (spin > target)
	{
		spin -= SMOOTH_MOVE;
	}
	glPushMatrix();
	{
		glTranslatef(0, -0.355, 4.121);
		glRotatef(spin, 1, 0, 0);
		glScalef(1.160, 1.399, 1.307);
		drawHead();
	}
	glPopMatrix();
}

-(void)spin:(float)degrees
{
	target += degrees;
}

@end
